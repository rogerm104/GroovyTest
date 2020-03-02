package com.restinterface

import com.google.gson.JsonArray
import com.google.gson.JsonObject

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Invocation
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

		String url = "https://hooks.zapier.com/hooks/catch/3320164/az95by";
		
        String authString = "user" + ":" + "user";
       // String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
		Client client = ClientBuilder.newBuilder().build();
        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Basic " + "");

        Response response = invocationBuilder.get();
        String output = response.readEntity(String.class);

        System.out.println(response.toString());
        JsonObject obj = new JsonObject(output);

