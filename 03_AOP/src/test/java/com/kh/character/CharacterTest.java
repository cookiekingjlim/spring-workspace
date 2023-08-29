package com.kh.character;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CharacterTest {
	
	@Autowired(required=false)
	private Character character;

	@Test
	void test() {}
	
	@Test
	void create() {
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
	
	@Test
	void questTest() throws Exception {
		assertThat(character.quest("일시점검 중이지롱ㅋ")).contains("일시점검 중이지롱ㅋ");
	}
	
	@Test
	void attackTest() throws Exception {
		assertThat(character.getWeapon().attack()).isNotNull();
	}
}
