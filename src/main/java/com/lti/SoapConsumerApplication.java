package com.lti;

import java.math.BigInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lti.client.SOAPConnector;
import com.lti.model.NumberToWords;
import com.lti.model.NumberToWordsResponse;

@SpringBootApplication
public class SoapConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			NumberToWords request = new NumberToWords();

			request.setUbiNum(BigInteger.valueOf(438100));

			NumberToWordsResponse response = (NumberToWordsResponse) soapConnector
					.callWebService("https://www.dataaccess.com/webservicesserver/NumberConversion.wso", request);

			System.out.println(response.getNumberToWordsResult());
		};
	}
}
