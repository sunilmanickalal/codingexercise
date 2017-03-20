package com.comcast.adcampaign.sources.services;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.comcast.adcampaign.sources.entities.Campaign;
import com.comcast.adcampaign.sources.restservices.AdCampaignRestService;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdCampaignRestService.class)
public class AdCampaignRestServiceTest {
	
	@Autowired
	private MockMvc mmvc;
	
	@MockBean
	private AdCampaignService adService;
	
	@Test
	public void testFindByCampaignId() throws Exception {
		Timestamp ts = new Timestamp(1490005947091L);
		String partnerId = "P001";
		Campaign cob = new Campaign(partnerId,30, "This is test content", ts);
		String screationDate = "Mar/20/2017 06:32:27";
		cob.setScreationDate(screationDate);
		
		given(adService.findByPartnerId(partnerId)).willReturn(cob);
		
		String URL = "/adservice/findByCampaignId/{partnerId}";
		
		String expectedJsonContent = "{\"partner_id\": \"P001\",\"duration\": 30,\"ad_content\": \"This is test content\",\"creation_date\": 1490005947091,\"screationDate\": \"Mar/20/2017 06:32:27\"}";
		
		mmvc.perform(get(URL, partnerId).accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().json(expectedJsonContent));
	}

}
