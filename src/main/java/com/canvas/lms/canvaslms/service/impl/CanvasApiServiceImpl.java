package com.canvas.lms.canvaslms.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.canvas.lms.canvaslms.entity.CanvasAccount;
import com.canvas.lms.canvaslms.entity.CanvasCourse;
import com.canvas.lms.canvaslms.entity.Roster;
import com.canvas.lms.canvaslms.exception.CanvasApiException;
import com.canvas.lms.canvaslms.service.ICanvasApiService;

@Service
public class CanvasApiServiceImpl implements ICanvasApiService {

	@Value("${canvas.api.base-url}")
    private String canvasBaseUrl;

    @Value("${canvas.api.access-token}")
    private String canvasAccessToken;

    @Override
    public List<Roster> getRosters() throws CanvasApiException {
        String endpoint = "/api/v1/courses";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(canvasBaseUrl + endpoint)
            .queryParam("access_token", canvasAccessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<Roster[]> responseEntity = restTemplate.exchange(builder.toUriString(),
        		HttpMethod.GET, new HttpEntity<>(headers), Roster[].class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            throw new CanvasApiException("Failed to fetch class rosters from Canvas API.");
        }
    }

	@Override
	public List<CanvasAccount> getCanvasAccounts() throws CanvasApiException {
		String endpoint = "/api/v1/accounts";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(canvasBaseUrl + endpoint)
            .queryParam("access_token", canvasAccessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CanvasAccount[]> responseEntity = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            new HttpEntity<>(headers),
            CanvasAccount[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            throw new CanvasApiException("Failed to fetch Canvas accounts from Canvas API.");
        }
    }

	@Override
	public List<CanvasCourse> getCanvasCourses() throws CanvasApiException {
		String endpoint = "/api/v1/courses";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(canvasBaseUrl + endpoint)
            .queryParam("access_token", canvasAccessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CanvasCourse[]> responseEntity = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            new HttpEntity<>(headers),
            CanvasCourse[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            throw new CanvasApiException("Failed to fetch Canvas courses from Canvas API.");
        }
    }

}
