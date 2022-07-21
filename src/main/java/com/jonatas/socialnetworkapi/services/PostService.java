package com.jonatas.socialnetworkapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonatas.socialnetworkapi.entities.Comment;
import com.jonatas.socialnetworkapi.entities.Entity;
import com.jonatas.socialnetworkapi.entities.Group;
import com.jonatas.socialnetworkapi.entities.Post;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.entities.dto.PostTalkDTO;
import com.jonatas.socialnetworkapi.entities.dto.PostTalkGroupDTO;
import com.jonatas.socialnetworkapi.entities.dto.PostUpdateDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.CommentMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.PostTalkGroupMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.PostTalkMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.PostUpdateMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.UserMiniDTO;
import com.jonatas.socialnetworkapi.entities.helper.LikeUser;
import com.jonatas.socialnetworkapi.entities.helper.PostUser;
import com.jonatas.socialnetworkapi.entities.post.Talk;
import com.jonatas.socialnetworkapi.entities.post.TalkGroup;
import com.jonatas.socialnetworkapi.entities.post.Update;
import com.jonatas.socialnetworkapi.enuns.TypeObject;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.enuns.TypePostVisibility;
import com.jonatas.socialnetworkapi.repositories.PostRepository;

@Service
public class PostService {
	
	//repositories

	@Autowired
	private PostRepository postRepository;
	
	//services
	
	@Autowired
	@Lazy
	private UserService userService;
	
	@Autowired
	@Lazy
	private EntityService entityService;
			
	@Autowired
	@Lazy
	private GroupService groupService;
	
	//methods
	
	//get
		
	public ResponseEntity<Object> findAllMini(String idUser){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Sort sort = Sort.by("release").descending();
			List<Post> posts = postRepository.findAll(sort);
			List<Object> objs = new ArrayList<>();
			for(Post post : posts) {
				System.out.println(post.getId());
				if(post.getTypePost() == TypePost.UPDATE) {
					PostUpdateMiniDTO postUpdateMiniDTO = new PostUpdateMiniDTO((Update) post);
					objs.add(postUpdateMiniDTO);
				}else if(post.getTypePost() == TypePost.TALK_USER) {
					PostTalkMiniDTO postTalkMiniDTO = new PostTalkMiniDTO((Talk) post);
					objs.add(postTalkMiniDTO);
					
				}else if(post.getTypePost() == TypePost.TALK_GROUP) {
					PostTalkGroupMiniDTO postTalkGroupMiniDTO = new PostTalkGroupMiniDTO((TalkGroup) post, user);
					objs.add(postTalkGroupMiniDTO);
				}
			
			}
			return ResponseEntity.ok().body(objs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Object> findByIdMini(String idPost, String idUser){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Post post = postRepository.findById(idPost).get();
			if(post.getTypePost() == TypePost.UPDATE) {
				PostUpdateMiniDTO postUpdateMiniDTO = new PostUpdateMiniDTO((Update) post);
				if(post.getLikes().contains(user)) {
					postUpdateMiniDTO.setLiked(true);
				}else {
					postUpdateMiniDTO.setLiked(false);
				}
				if(!post.getLikes().isEmpty()) {
					UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
					if(userMiniDTO.getId().hashCode() != idUser.hashCode()) {
						postUpdateMiniDTO.setLike(userMiniDTO);
					}else {
						if(post.getLikes().size() > 1) {
							userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
							postUpdateMiniDTO.setLike(userMiniDTO);
						}
					}
				}
				return ResponseEntity.ok().body(postUpdateMiniDTO);
			}else if(post.getTypePost() == TypePost.TALK_USER) {
				PostTalkMiniDTO postTalkMiniDTO = new PostTalkMiniDTO((Talk) post);
				if(post.getLikes().contains(user)) {
					postTalkMiniDTO.setLiked(true);
				}else {
					postTalkMiniDTO.setLiked(false);
				}
				if(!post.getLikes().isEmpty()) {
					UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
					if(userMiniDTO.getId().hashCode() != idUser.hashCode()) {
						postTalkMiniDTO.setLike(userMiniDTO);
					}else {
						if(post.getLikes().size() > 1) {
							userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
							postTalkMiniDTO.setLike(userMiniDTO);
						}
					}
				}
				return ResponseEntity.ok().body(postTalkMiniDTO); 
			}else if(post.getTypePost() == TypePost.TALK_GROUP) {
				PostTalkGroupMiniDTO postTalkGroupMiniDTO  = new PostTalkGroupMiniDTO((TalkGroup) post, user);
				if(post.getLikes().contains(user)) {
					postTalkGroupMiniDTO.setLiked(true);
				}else {
					postTalkGroupMiniDTO.setLiked(false);
				}
				if(!post.getLikes().isEmpty()) {
					UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
					if(userMiniDTO.getId().hashCode() != idUser.hashCode()) {
						postTalkGroupMiniDTO.setLike(userMiniDTO);
					}else {
						if(post.getLikes().size() > 1) {
							userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
							postTalkGroupMiniDTO.setLike(userMiniDTO);
						}
					}
				}
				return ResponseEntity.ok().body(postTalkGroupMiniDTO); 
			}
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
		return null;
	}
	
	public ResponseEntity<Object> getPostAll(String id){
		try {
			User user = (User) userService.findById(id).getBody();
			List<Group> groups = user.getGroups();
			Sort sort = Sort.by("release").descending();
			List<Post> objs = postRepository.findAll(sort);
			List<Object> posts = new ArrayList<>();
			List<String> ids = new ArrayList<>();
			for(User following : user.getFollower().getFollowing()) {
				ids.add(following.getId());
			}
			int value = 0;
			for(Post post : objs) {
				if(post.getTypePostVisibility() == TypePostVisibility.USER) {
					if(ids.contains(post.getAuthor().getId()) || user.getId().hashCode() == post.getAuthor().getId().hashCode() ) {
						if(post.getTypePost() == TypePost.UPDATE) {
							PostUpdateMiniDTO postUpdateMiniDTO = new PostUpdateMiniDTO((Update) post);
							if(post.getLikes().contains(user)) {
								postUpdateMiniDTO.setLiked(true);
							}else {
								postUpdateMiniDTO.setLiked(false);
							}
							if(!post.getLikes().isEmpty()) {
								UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
								if(userMiniDTO.getId().hashCode() != id.hashCode()) {
									postUpdateMiniDTO.setLike(userMiniDTO);
								}else {
									if(post.getLikes().size() > 1) {
										userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
										postUpdateMiniDTO.setLike(userMiniDTO);
									}
								}
							}
							
							posts.add(postUpdateMiniDTO);
						}else if(post.getTypePost() == TypePost.TALK_USER) {
							PostTalkMiniDTO postTalkMiniDTO = new PostTalkMiniDTO((Talk) post);
							
							if(post.getLikes().contains(user)) {
								postTalkMiniDTO.setLiked(true);
							}else {
								postTalkMiniDTO.setLiked(false);
							}
							if(!post.getLikes().isEmpty()) {
								UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
								if(userMiniDTO.getId().hashCode() != id.hashCode()) {
									postTalkMiniDTO.setLike(userMiniDTO);
								}else {
									if(post.getLikes().size() > 1) {
										userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
										postTalkMiniDTO.setLike(userMiniDTO);
									}
								}
							}
							posts.add(postTalkMiniDTO);
						}
						
					}
					
				}else if(post.getTypePostVisibility() == TypePostVisibility.GROUP) {
					if(post.getTypePost() == TypePost.TALK_GROUP) {
						TalkGroup postTalkGroup =  (TalkGroup) post;
						if(groups.contains(postTalkGroup.getGroup())) {
							PostTalkGroupMiniDTO postTalkGroupMiniDTO = new PostTalkGroupMiniDTO(postTalkGroup, user);
							if(post.getLikes().contains(user)) {
								postTalkGroupMiniDTO.setLiked(true);
							}else {
								postTalkGroupMiniDTO.setLiked(false);
							}
							if(!post.getLikes().isEmpty()) {
								UserMiniDTO userMiniDTO = new UserMiniDTO(post.getLikes().get(0));
								if(userMiniDTO.getId().hashCode() != id.hashCode()) {
									postTalkGroupMiniDTO.setLike(userMiniDTO);
								}else {
									if(post.getLikes().size() > 1) {
										userMiniDTO = new UserMiniDTO(post.getLikes().get(1));
										postTalkGroupMiniDTO.setLike(userMiniDTO);
									}
								}
							}
							
							posts.add(postTalkGroupMiniDTO);
						}
					}
				}
				value += value;
				if(value >= 500) {
					return ResponseEntity.ok().body(posts); 
				}
			}
			
			return ResponseEntity.ok().body(posts);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
		
	public ResponseEntity<Object> getCommentsMini(String idPost, String idUser){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Post post = postRepository.findById(idPost).get();
			List<Comment> comments = post.getComments();
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
			return ResponseEntity.ok().body(commentMiniDTOs);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> getLikes(String id){
		try {
			Post post = postRepository.findById(id).get();
			List<User> likes = post.getLikes();
			List<UserMiniDTO> userMiniDTOs = new ArrayList<>();
			for(User user : likes) {
				UserMiniDTO userMiniDTO = new UserMiniDTO(user);
				userMiniDTOs.add(userMiniDTO);
			}
			return ResponseEntity.ok().body(userMiniDTOs);
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//post
	
	public ResponseEntity<Object> newPostUpdate(PostUpdateDTO postDTO){
		try {
			if(postDTO.getRelease() == null) {
				return ResponseEntity.badRequest().build();
			}
			User user = (User) userService.findById(postDTO.getIdAuthor()).getBody();
			Entity entity = (Entity) entityService.findById(postDTO.getIdEntity()).getBody();
			Update post = new Update(
					postDTO.getRelease(),
					postDTO.getBody(),
					postDTO.getTypePost(),
					TypePostVisibility.USER,
					user,
					postDTO.getSpoiler(),
					postDTO.getCategory(),
					postDTO.getLevel(),
					postDTO.getEvaluation(),
					entity
					);
			Post obj = post;
			obj = postRepository.insert(obj);
			PostUser postUser = new PostUser(obj.getId(), obj.getTypePost());
			user.getPosts().add(postUser);
			userService.save(user);
			PostUpdateMiniDTO postUpdateMiniDTO = new PostUpdateMiniDTO(post);
			return ResponseEntity.created(null).body(postUpdateMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
		
		
	public ResponseEntity<Object> newPostTalkUser(PostTalkDTO postDTO){
		try {
			if(postDTO.getRelease() == null) {
				return ResponseEntity.badRequest().build();
			}
			User user = (User) userService.findById(postDTO.getIdAuthor()).getBody();
			Talk post = new Talk(postDTO.getRelease(), postDTO.getBody(), TypePost.TALK_USER, TypePostVisibility.USER, user, postDTO.getSpoiler());
			if(postDTO.getSpoiler()) {
				if(postDTO.getTitle() == null) {
					return ResponseEntity.badRequest().build();
				}else {
					post.setTitle(postDTO.getTitle());
				}
			}
			post = postRepository.insert(post);
			PostUser postUser = new PostUser(post.getId(), post.getTypePost());
			user.getPosts().add(postUser);
			userService.save(user);
			PostTalkMiniDTO postTalkMiniDTO = new PostTalkMiniDTO(post);
			return ResponseEntity.created(null).body(postTalkMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> newPostTalkGroup(PostTalkGroupDTO postDTO){
		try {
			if(postDTO.getRelease() == null) {
				return ResponseEntity.badRequest().build();
			}
			User user = (User) userService.findById(postDTO.getIdAuthor()).getBody();
			Group group = groupService.findById(postDTO.getIdGroup());
			if(group.getMembersSilenced().contains(user)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			TalkGroup post = new TalkGroup(postDTO.getRelease(), postDTO.getBody(), TypePost.TALK_GROUP, TypePostVisibility.GROUP, user, postDTO.getSpoiler(), false, null, group);
			if(postDTO.getSpoiler()) {
				if(postDTO.getTitle() == null) {
					return ResponseEntity.badRequest().build();
				}else {
					post.setTitle(postDTO.getTitle());
				}
			}
			post = postRepository.insert(post);
			PostUser postUser = new PostUser(post.getId(), post.getTypePost());
			user.getPosts().add(postUser);
			userService.save(user);
			group.getPosts().add(post);
			groupService.save(group);
			PostTalkGroupMiniDTO postTalkGroupMiniDTO = new PostTalkGroupMiniDTO(post, user);
			return ResponseEntity.created(null).body(postTalkGroupMiniDTO);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
		
	//delete
	
	public ResponseEntity<Object> deletePost(String idPost, String idUser){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Post post = (Post) postRepository.findById(idPost).get();
			if(user.getId().hashCode() != post.getAuthor().getId().hashCode()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			PostUser postUser = new PostUser(post.getId(), post.getTypePost());
			user.getPosts().remove(postUser);
			userService.save(user);
			if(post.getTypePost().equals(TypePost.TALK_GROUP)) {
				TalkGroup talkGroup = (TalkGroup) post;
				Group group = talkGroup.getGroup();
				group.getPosts().remove(talkGroup);
				groupService.save(group);
			}
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	//put
	
	public ResponseEntity<Object> addBodyUpdatePost(PostUpdateDTO postUpdateDTO){
		try {
			User user = (User) userService.findById(postUpdateDTO.getIdAuthor()).getBody();
			Post post = (Update) postRepository.findById(postUpdateDTO.getIdPost()).get();
			
			if(!(user.getId().hashCode() == post.getAuthor().getId().hashCode())) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			post.setBody(postUpdateDTO.getBody());
			post.setSpoiler(postUpdateDTO.getSpoiler());
			postRepository.save(post);
			return ResponseEntity.accepted().build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	public ResponseEntity<Object> addLike(String idUser, String idPost){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Post post = postRepository.findById(idPost).get();
			List<User> users = post.getLikes();
			if(users.contains(user)) {
				return removeLike(idUser, idPost);
			}
			post.getLikes().add(user);
			postRepository.save(post);
			LikeUser like = new LikeUser(post.getId(), TypeObject.POST);
			user.getLikes().add(like);
			userService.save(user);
			return ResponseEntity.accepted().build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> removeLike(String idUser, String idPost){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Post post = postRepository.findById(idPost).get();
			post.getLikes().remove(user);
			postRepository.save(post);
			LikeUser like = new LikeUser(post.getId(), TypeObject.POST);
			user.getLikes().remove(like);
			userService.save(user);
			return ResponseEntity.accepted().build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Object> closeTalkGroup(String idUser, String idPost, String idGroup){
		try {
			User user = (User) userService.findById(idUser).getBody();
			Group group = groupService.findById(idGroup);
			TalkGroup post = (TalkGroup) postRepository.findById(idPost).get();
			if(!post.getTypePost().equals(TypePost.TALK_GROUP)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			if(!group.getModerators().contains(user) && !group.getCreator().equals(user)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			post.setClose(true);
			post.setClosedBy(user);
			postRepository.save(post);
			return ResponseEntity.accepted().build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//internal
	
	public ResponseEntity<Object> findById(String id){
		try {
			Post post = postRepository.findById(id).get();
			return ResponseEntity.ok().body(post);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Void> save(Post post){
		try {
			postRepository.save(post);
			return ResponseEntity.accepted().build();
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
