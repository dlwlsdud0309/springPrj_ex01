package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//전달하는 데이터가 SampleDTO와 같이 객체 타입이고 여러 개를 처리해야 한다면
@Data
public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	//List컬렉션에 대하여
	//List<E> list = new ArrayList<E>(); --E에 지정된 타입의 객체만 저장
	//List<E> list = new ArrayList<>(); --E에 지정된 타입의 객체만 저장
	//List list = new ArrayList(); --모든 타입의 객체를 저장
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
}
