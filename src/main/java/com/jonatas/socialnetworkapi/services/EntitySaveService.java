package com.jonatas.socialnetworkapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonatas.socialnetworkapi.entities.Comment;
import com.jonatas.socialnetworkapi.entities.Entity;
import com.jonatas.socialnetworkapi.entities.EntitySave;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.entities.dto.EntitySaveDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.CommentMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.EntitySaveMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.UserMiniDTO;
import com.jonatas.socialnetworkapi.entities.helper.LikeUser;
import com.jonatas.socialnetworkapi.enuns.Level;
import com.jonatas.socialnetworkapi.enuns.TypeObject;
import com.jonatas.socialnetworkapi.repositories.EntitySaveRepository;

@Service
public class EntitySaveService {

	//repositories
	
	@Autowired
	private EntitySaveRepository entitySaveRepository;
	
	//services
	
	@Autowired
	@Lazy
	private UserService userService;
	
	@Autowired
	@Lazy
	private EntityService entityService;
	
	@Autowired
	@Lazy
	private PostService postService;

	
	//methods
	
	//get
	
	public ResponseEntity<Object> findAllMini(String idUser){
		try {
			List<EntitySave> list = entitySaveRepository.findAll();
			User user  = (User) userService.findById(idUser).getBody();
			List<EntitySaveMiniDTO> entitySaveMiniDTOs = new ArrayList<>();
			for(EntitySave entitySave : list) {
				EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);

				if(entitySave.getLikes().contains(user)) {
					entitySaveMiniDTO.setLiked(true);
				}else {
					entitySaveMiniDTO.setLiked(false);
				}
				if(!entitySave.getLikes().isEmpty()) {
					UserMiniDTO userMiniDTO = new UserMiniDTO(entitySave.getLikes().get(0));
					if(userMiniDTO.getId().hashCode() != idUser.hashCode()) {
						entitySaveMiniDTO.setLike(userMiniDTO);
					}else {
						if(entitySave.getLikes().size() > 1) {
							userMiniDTO = new UserMiniDTO(entitySave.getLikes().get(1));
							entitySaveMiniDTO.setLike(userMiniDTO);
						}
					}
				}
				entitySaveMiniDTOs.add(entitySaveMiniDTO);
			}
			return ResponseEntity.ok(entitySaveMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> findByIdMini(String idEntitySave, String idUser){
		try {
			EntitySave entitySave = entitySaveRepository.findById(idEntitySave).get();
			User user  = (User) userService.findById(idUser).getBody();
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			
			if(entitySave.getLikes().contains(user)) {
				entitySaveMiniDTO.setLiked(true);
			}else {
				entitySaveMiniDTO.setLiked(false);
			}
			if(!entitySave.getLikes().isEmpty()) {
				UserMiniDTO userMiniDTO = new UserMiniDTO(entitySave.getLikes().get(0));
				if(userMiniDTO.getId().hashCode() != idUser.hashCode()) {
					entitySaveMiniDTO.setLike(userMiniDTO);
				}else {
					if(entitySave.getLikes().size() > 1) {
						userMiniDTO = new UserMiniDTO(entitySave.getLikes().get(1));
						entitySaveMiniDTO.setLike(userMiniDTO);
					}
				}
			}
			
			return ResponseEntity.ok(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Object> getLikes(String id){
		try {
			EntitySave entitySave = entitySaveRepository.findById(id).get();
			List<User> users = entitySave.getLikes();
			List<UserMiniDTO> userMiniDTOs = new ArrayList<>();
			for(User user : users) {
				UserMiniDTO userMiniDTO = new UserMiniDTO(user);
				userMiniDTOs.add(userMiniDTO);
			}
			return ResponseEntity.ok(userMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Object> getCommentsMini(String idEntitySave, String idUser){
		try {
			User user = (User) userService.findById(idUser).getBody();
			EntitySave entitySave = entitySaveRepository.findById(idEntitySave).get();
			List<Comment> comments = entitySave.getComments();
			List<CommentMiniDTO> commentMiniDTOs = new ArrayList<>();
			for(Comment comment : comments) {
				CommentMiniDTO commentMiniDTO = new CommentMiniDTO(comment);
				if(comment.getLikes().contains(user)) {
					commentMiniDTO.setLiked(true);
				}else {
					commentMiniDTO.setLiked(false);
				}
				commentMiniDTOs.add(commentMiniDTO);
			}
			return ResponseEntity.ok(commentMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//post
	
	public ResponseEntity<Object> newEntitySaveEntity(EntitySaveDTO entitySaveDTO){
		try {
			User user = (User) userService.findById(entitySaveDTO.getIdUser()).getBody();
			Entity entity = (Entity) entityService.findById(entitySaveDTO.getIdEntity()).getBody();
			if(entitySaveDTO.getCategory() < 1 || entitySaveDTO.getCategory() > 4) {
				return ResponseEntity.badRequest().build();
			}
			EntitySave entitySave = new EntitySave(
					user,
					entity,
					entitySaveDTO.getCategory(),
					Level.ENTITY, 
					entitySaveDTO.isSpoiler()
					);
			List<EntitySave> entitySaves = user.getEntitySaves();
			for(EntitySave obj : entitySaves) {
				boolean entitySaveExists = false;
				if(obj.getLevel() == Level.ENTITY) {
					if(obj.getEntity().getId().hashCode() == entity.getId().hashCode()) {
						entitySaveExists = true;
					}
					if(entitySaveExists) {
						return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
					}
				}
			}
			entitySave = entitySaveRepository.insert(entitySave);
			user.getEntitySaves().add(entitySave);
			userService.save(user);
			entity.getEntitySaves().add(entitySave);
			switch (entitySaveDTO.getCategory()) {
			case 1:
				entity.setCategory1(1);
				break;
			case 2:
				entity.setCategory2(1);
				break;
			case 3:
				entity.setCategory3(1);
				break;
			case 4:
				entity.setCategory4(1);
				break;
			}
			entityService.save(entity);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.created(null).body(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
		
	
	//put
	
	public ResponseEntity<Object> updateLike(String idUser, String idEntitySave){
		try {
			EntitySave entitySave = entitySaveRepository.findById(idEntitySave).get();
			User user = (User) userService.findById(idUser).getBody();
			//List<User> users = entitySave.getLikes();
			if(entitySave.getLikes().contains(user)) {
				return removeLike(user.getId(), entitySave.getId());
			}
			LikeUser likeUser = new LikeUser(entitySave.getId(), TypeObject.ENTITY_SAVE);
			user.getLikes().add(likeUser);
			entitySave.getLikes().add(user);
			entitySaveRepository.save(entitySave);
			userService.save(user);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> removeLike(String idUser, String idEntitySave){
		try {
			User user = (User) userService.findById(idUser).getBody();
			EntitySave entitySave = entitySaveRepository.findById(idEntitySave).get();
			entitySave.getLikes().remove(user);
			entitySaveRepository.save(entitySave);
			LikeUser like = new LikeUser(entitySave.getId(), TypeObject.ENTITY_SAVE);
			user.getLikes().remove(like);
			userService.save(user);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> updateEntitySaveCategory(EntitySaveDTO entitySaveDTO){
		try {
			EntitySave entitySave = entitySaveRepository.findById(entitySaveDTO.getIdEntitySave()).get();
			if(entitySaveDTO.getCategory() < 1 || entitySaveDTO.getCategory() > 4) {
				return ResponseEntity.badRequest().build();
			}
			switch (entitySave.getLevel()) {
			case ENTITY:
				updateQuantityCategoryEntity(entitySave, entitySave.getCategory(), entitySaveDTO.getCategory());
				break;
		
			}
			entitySave.setCategory(entitySaveDTO.getCategory());
			entitySave = entitySaveRepository.save(entitySave);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
			
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> updateEntitySaveEvaluation(EntitySaveDTO entitySaveDTO){
		try {
			EntitySave entitySave = entitySaveRepository.findById(entitySaveDTO.getIdEntitySave()).get();
			if(entitySaveDTO.getEvaluation() < 1 || entitySaveDTO.getEvaluation() > 5) {
				return ResponseEntity.badRequest().build();
			}
			switch (entitySave.getLevel()) {
			case ENTITY:
				if(entitySave.isRated()) {
					Entity entity = entitySave.getEntity();
					entity.setEvaluationSum(- entitySave.getEvaluation());
					entity.setEvaluationSum(+ entitySaveDTO.getEvaluation());
					entity.setEvaluationAverage();
					entityService.save(entity);
				}else {
					Entity entity = entitySave.getEntity();
					entity.setEvaluationSum(+ entitySaveDTO.getEvaluation());
					entity.setEvaluationQuantity(+ 1);
					entity.setEvaluationAverage();
					entityService.save(entity);
				}
				break;
			
			}
			
			entitySave.setEvaluation(entitySaveDTO.getEvaluation());
			entitySave.setRated(true);
			entitySave = entitySaveRepository.save(entitySave);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> updateEntitySaveGoal(EntitySaveDTO entitySaveDTO){
		try {
			EntitySave entitySave = entitySaveRepository.findById(entitySaveDTO.getIdEntitySave()).get();
			entitySave.setGoal(entitySaveDTO.isGoal());		
			entitySave = entitySaveRepository.save(entitySave);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	
	public ResponseEntity<Object> updateEntitySaveReview(EntitySaveDTO entitySaveDTO){
		try {
			EntitySave entitySave = entitySaveRepository.findById(entitySaveDTO.getIdEntitySave()).get();
			entitySave.setReviewed(entitySaveDTO.isReviewed());	
			entitySave.setReview(entitySaveDTO.getReview());
			entitySave.setSpoiler(entitySaveDTO.isSpoiler());
			entitySave.setRelease(entitySaveDTO.getRelease());
			entitySave = entitySaveRepository.save(entitySave);
			EntitySaveMiniDTO entitySaveMiniDTO = new EntitySaveMiniDTO(entitySave);
			return ResponseEntity.accepted().body(entitySaveMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//delete
	
	public ResponseEntity<Object> deleteEntitySaveEntity(EntitySaveDTO entitySaveDTO){
		try {
			User user = (User) userService.findById(entitySaveDTO.getIdUser()).getBody();
			Entity entity = (Entity) entityService.findById(entitySaveDTO.getIdEntity()).getBody();
			EntitySave entitySave = entitySaveRepository.findById(entitySaveDTO.getIdEntitySave()).get();
			user.getEntitySaves().remove(entitySave);
			userService.save(user);
			entity.getEntitySaves().remove(entitySave);
			entityService.save(entity);
			entitySaveRepository.delete(entitySave);
			return ResponseEntity.ok().build();
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//internal
	
	public ResponseEntity<Object> save(EntitySave entitySave){
		try {
			entitySave = entitySaveRepository.save(entitySave);
			return ResponseEntity.accepted().body(entitySave);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> findById(String id){
		try {
			EntitySave entitySave = entitySaveRepository.findById(id).get();
			return ResponseEntity.accepted().body(entitySave);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> updateQuantityCategoryEntity(EntitySave entitySave, int current, int newValue){
		try {
			Entity entity = entitySave.getEntity();

			switch (current) {
			case 1:
				entity.setCategory1(-1);
				break;
			case 2:
				entity.setCategory2(-1);
				break;
			case 3:
				entity.setCategory3(-1);
				break;
			case 4:
				entity.setCategory4(-1);
				break;
			}
			
			switch (newValue) {
			case 1:
				entity.setCategory1(1);
				break;
			case 2:
				entity.setCategory2(1);
				break;
			case 3:
				entity.setCategory3(1);
				break;
			case 4:
				entity.setCategory4(1);
				break;
			}
			entityService.save(entity);
			return ResponseEntity.accepted().body(entitySave);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
		
	
}
