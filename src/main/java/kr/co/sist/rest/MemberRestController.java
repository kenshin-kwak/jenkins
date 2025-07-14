package kr.co.sist.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

	//아이디를 키로 MemberDTO를 저장
	private Map<String, MemberDTO> memberMap =new HashMap<String,MemberDTO>();
	
	@PostMapping("/member")
	public MessageDTO addMember(@RequestBody MemberDTO mDTO ) {
		String msg="추가 실패 - 아이디가 존재합니다.";
		String id=mDTO.getId();
		if( !memberMap.containsKey(id)) {
			memberMap.put( id, mDTO);
			msg="추가 성공";
		}//end if
		MessageDTO msgDTO=new MessageDTO(msg);
		return msgDTO;
	}//addMember
	
	
	@GetMapping("/members")
	//RestController는 return 객체( Map, List, Set, DTO )를 JSON문자열로 변환하여 응답
	public Collection<MemberDTO> searchAllMember(){
		Collection<MemberDTO> collection=memberMap.values();
		return collection;
	}
	
	@GetMapping("/members/{id}")
	public MemberDTO searchOneMember(@PathVariable String id ){
		MemberDTO mDTO=memberMap.get( id );
		return mDTO;
	}
	
	@PutMapping("/members/{id}")
	public MessageDTO modifyMember(@PathVariable String id ,
				@RequestBody MemberDTO mDTO){
		MessageDTO msgDTO=new MessageDTO("아이디가 존재하지 않습니다.");
		
		if( memberMap.containsKey(id) ) {
			msgDTO.setMessage(id+"회원 정보를 변경하였습니다.");
			memberMap.put(id, mDTO);
		}//end if
		return msgDTO;
	}//modifyMember
	
	@DeleteMapping("/members/{id}")
	public MessageDTO removeMember(@PathVariable String id ){
		MessageDTO msgDTO=new MessageDTO("아이디가 존재하지 않습니다.",false);
		
		if( memberMap.containsKey(id) ) {
			msgDTO.setMessage(id+"회원 정보를 삭제하였습니다.");
			msgDTO.setFlag(true);
			memberMap.remove(id);
		}//end if
		return msgDTO;
	}//modifyMember
	
}//class
