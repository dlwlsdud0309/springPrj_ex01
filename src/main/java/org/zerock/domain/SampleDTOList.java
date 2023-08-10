package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//전달하는 데이터가 SampleDTO와 같이 객체 타입이고 여러 개를 처리해야 한다면
@Data
public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
}
