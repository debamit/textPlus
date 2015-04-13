package com.textplus.proj;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.textplus.proj.controller.MemberController;
import com.textplus.proj.domain.Member;
import com.textplus.proj.service.MemberService;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {
	 private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
	            MediaType.APPLICATION_JSON.getSubtype(),
	            Charset.forName("utf8")
	    );
	
	private MockMvc mockMvc;
	
	@Mock
	private MemberService meberServiceMock;
	
	@InjectMocks
    private MemberController memberController;

    @Before
    public void setUp() {
 
        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }
	
	@Test 
	public void findAll_Members_ShouldReturnAllMembers()throws Exception{
		Member one = new Member(1L, "test1@test.com","test1", "310-331-1190");
		Member two = new Member(2L, "test2@test.com","test2", "310-332-2290");
		
		when(meberServiceMock.findAll()).thenReturn(Arrays.asList(one, two));
		mockMvc.perform(get("/api/members"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].email", is("test1@test.com")))
        .andExpect(jsonPath("$[0].name", is("test1")))
        .andExpect(jsonPath("$[0].phone", is("310-331-1190")))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].email", is("test2@test.com")))
        .andExpect(jsonPath("$[1].name", is("test2")))
        .andExpect(jsonPath("$[1].phone", is("310-332-2290")));
		
		 verify(meberServiceMock, times(1)).findAll();
	        verifyNoMoreInteractions(meberServiceMock);
	}
	
	 @Test
	    public void create_TodoEntryWithOnlyTitle_ShouldCreateNewTodoEntryWithoutDescription() throws Exception {
		 	Member newMember = new Member(1L, "test1@test.com","test1", "310-331-1190");

	        mockMvc.perform(post("/api/members/create")
	                        .contentType(APPLICATION_JSON_UTF8)
	                        .content(TestUtil.convertObjectToJsonBytes(newMember))
	        );

	        ArgumentCaptor<Member> createdArgument = ArgumentCaptor.forClass(Member.class);
	        verify(meberServiceMock, times(1)).save(createdArgument.capture());
	        verifyNoMoreInteractions(meberServiceMock);
	    }



}
