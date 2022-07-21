package com.jonatas.socialnetworkapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jonatas.socialnetworkapi.entities.Group;
import com.jonatas.socialnetworkapi.entities.Post;
import com.jonatas.socialnetworkapi.entities.User;
import com.jonatas.socialnetworkapi.entities.dto.GroupDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.GroupMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.PostTalkGroupMiniDTO;
import com.jonatas.socialnetworkapi.entities.dto.mini.UserMiniDTO;
import com.jonatas.socialnetworkapi.entities.post.TalkGroup;
import com.jonatas.socialnetworkapi.enuns.TypePost;
import com.jonatas.socialnetworkapi.repositories.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	@Lazy
	private UserService userService;
	
	//get
	public List<GroupMiniDTO> getGroups(String id) {
		User user = (User) userService.findById(id).getBody();
		List<Group> groups = groupRepository.findAll();
		List<GroupMiniDTO> groupMiniDTOs = new ArrayList<>();
		for(Group group : groups) {
			GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group, user);
			if(group.getMembers().contains(user) || group.getCreator().equals(user)) {
				groupMiniDTO.setUserIsMember(true);
			}else {
				groupMiniDTO.setUserIsMember(false);
			}
			if(group.getModerators().contains(user) || group.getCreator().equals(user)) {
				groupMiniDTO.setUserIsModerator(true);
			}else {
				groupMiniDTO.setUserIsModerator(false);
			}
			if(group.getMembersSilenced().contains(user)) {
				groupMiniDTO.setUserIsSilenced(true);
			}else {
				groupMiniDTO.setUserIsSilenced(false);
			}
			groupMiniDTOs.add(groupMiniDTO);
		}		
		return groupMiniDTOs;
	}
	
	public GroupMiniDTO getGroup(String idGroup, String idUser) {
		User user = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group, user);
		if(group.getMembers().contains(user) || group.getCreator().equals(user)) {
			groupMiniDTO.setUserIsMember(true);
		}else {
			groupMiniDTO.setUserIsMember(false);
		}
		if(group.getModerators().contains(user) || group.getCreator().equals(user)) {
			groupMiniDTO.setUserIsModerator(true);
		}else {
			groupMiniDTO.setUserIsModerator(false);
		}
		if(group.getMembersSilenced().contains(user)) {
			groupMiniDTO.setUserIsSilenced(true);
		}else {
			groupMiniDTO.setUserIsSilenced(false);
		}
		return groupMiniDTO;
	}
	
	public List<UserMiniDTO> getMembers(String idGroup){
		Group group = groupRepository.findById(idGroup).get();
		List<UserMiniDTO> members = new ArrayList<>();
		members.add(new UserMiniDTO(group.getCreator()));
		for(User user : group.getMembers()) {
			UserMiniDTO userMiniDTO = new UserMiniDTO(user);
			members.add(userMiniDTO);
		}
		return members;
	}
	
	public List<UserMiniDTO> getModerators(String idGroup){
		Group group = groupRepository.findById(idGroup).get();
		List<UserMiniDTO> moderators = new ArrayList<>();
		for(User user : group.getModerators()) {
			UserMiniDTO userMiniDTO = new UserMiniDTO(user);
			moderators.add(userMiniDTO);
		}
		return moderators;
	}
	
	public List<UserMiniDTO> getMembersSilenced(String idGroup){
		Group group = groupRepository.findById(idGroup).get();
		List<UserMiniDTO> silenced = new ArrayList<>();
		for(User user : group.getMembersSilenced()) {
			UserMiniDTO userMiniDTO = new UserMiniDTO(user);
			silenced.add(userMiniDTO);
		}
		return silenced;
	}
	
	public ResponseEntity<Object> findByName(String name){
		try {
			List<Group> groups = groupRepository.searchByName(name);
			List<GroupMiniDTO> groupMiniDTOs = new ArrayList<>();
			for(Group group : groups) {
				GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
				groupMiniDTOs.add(groupMiniDTO);
			}
			return ResponseEntity.ok().body(groupMiniDTOs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Object> getPostsGroup(String idGroup, String idUser){
		try {
			Group group = groupRepository.findById(idGroup).get();
			User user = (User) userService.findById(idUser).getBody();
			List<Post> posts = group.getPosts();
			List<Object> objs = new ArrayList<>();
			for(Post post : posts) {
				if(post.getTypePost() == TypePost.TALK_GROUP) {
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
					objs.add(0, postTalkGroupMiniDTO);;
				}
			}
			return ResponseEntity.ok().body(objs);
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//post
	
	public GroupMiniDTO createGroup(GroupDTO groupDTO) {
		User user = (User) userService.findById(groupDTO.getIdCreator()).getBody();
		Group group = new Group(groupDTO.getName(), groupDTO.getDescription(), user, groupDTO.getCreationDate());
		group = groupRepository.insert(group);
		user.getGroups().add(group);
		userService.save(user);
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		groupMiniDTO.setUserIsMember(true);
		return groupMiniDTO;
	}
	
	//put
	
	public GroupMiniDTO enterGroup(String idGroup, String idUser) {
		User user = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(!group.getMembers().contains(user) && !group.getCreator().equals(user)) {
			group.getMembers().add(user);
			groupRepository.save(group);
			user.getGroups().add(group);
			userService.save(user);
		}
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		groupMiniDTO.setUserIsMember(true);
		return groupMiniDTO;
	}
	
	public GroupMiniDTO goOutGroup(String idGroup, String idUser) {
		User user = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getMembers().contains(user) && !group.getCreator().equals(user)) {
			group.getMembers().remove(user);
			groupRepository.save(group);
			user.getGroups().remove(group);
			userService.save(user);
		}
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		groupMiniDTO.setUserIsMember(false);
		return groupMiniDTO;
	}
	
	
	
	public boolean addModerator(String idGroup, String idCreator, String idMember) {
		User creator = (User) userService.findById(idCreator).getBody();
		User member = (User) userService.findById(idMember).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getCreator().equals(creator) && group.getMembers().contains(member) ) {
			if(!group.getModerators().contains(member)) {
				group.getModerators().add(member);
				groupRepository.save(group);
				return true;
			}else{
				return 	true;
			}
		}else {
				return false;
		}
	}
	
	public boolean removeModerator(String idGroup, String idCreator, String idMember) {
		User creator = (User) userService.findById(idCreator).getBody();
		User member = (User) userService.findById(idMember).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getCreator().equals(creator) && group.getModerators().contains(member) ) {
			if(group.getModerators().contains(member)) {
				group.getModerators().remove(member);
				groupRepository.save(group);
				return true;
			}else{
				return 	true;
			}
		}else {
			return false;
		}
	}
	
	public boolean addMemberSilenced(String idGroup, String idModerator, String idMember) {
		User moderator = (User) userService.findById(idModerator).getBody();
		User member = (User) userService.findById(idMember).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if((group.getCreator().equals(moderator) || group.getModerators().contains(moderator)) && group.getMembers().contains(member) && !group.getModerators().contains(member)) {
			if(!group.getMembersSilenced().contains(member)) {
				group.getMembersSilenced().add(member);
				groupRepository.save(group);
				return true;
			}else{
				return 	true;
			}
		}else {
				return false;
		}
	}
	
	public boolean removeMemberSilenced(String idGroup, String idModerator, String idMember) {
		User moderator = (User) userService.findById(idModerator).getBody();
		User member = (User) userService.findById(idMember).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if((group.getCreator().equals(moderator) || group.getModerators().contains(moderator)) && group.getMembers().contains(member)) {
			if(group.getMembersSilenced().contains(member)) {
				group.getMembersSilenced().remove(member);
				groupRepository.save(group);
				return true;
			}else{
				return 	true;
			}
		}else {
				return false;
		}
	}
	
	
	public ResponseEntity<GroupMiniDTO> updateName(GroupDTO groupDTO, String idUser, String idGroup) {
		User creator = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getCreator().equals(creator)) {
			group.setName(groupDTO.getName());
			groupRepository.save(group);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupMiniDTO);
	}
	
	public ResponseEntity<GroupMiniDTO> updateDescription(GroupDTO groupDTO, String idUser, String idGroup) {
		User creator = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getCreator().equals(creator)) {
			group.setDescription(groupDTO.getDescription());
			groupRepository.save(group);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupMiniDTO);
	}
	
	public ResponseEntity<GroupMiniDTO> updateImage(GroupDTO groupDTO, String idUser, String idGroup) {
		User creator = (User) userService.findById(idUser).getBody();
		Group group = groupRepository.findById(idGroup).get();
		if(group.getCreator().equals(creator)) {
			group.setImage(groupDTO.getImage());
			groupRepository.save(group);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		GroupMiniDTO groupMiniDTO = new GroupMiniDTO(group);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupMiniDTO);
	}
	

	
	//internal
	
	public Group findById(String id) {
		return groupRepository.findById(id).get();
	}
	
	public Group save(Group group) {
		return groupRepository.save(group);
	}
	
	
	
}
