package kr.co.sist.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageDTO {
	private String message;
	private boolean flag;
	
	public MessageDTO(String message) {
		this.message=message;
	}
}
