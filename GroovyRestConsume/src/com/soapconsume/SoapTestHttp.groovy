package com.soapconsume

import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient

String wsSOAPURL="http://www.dneonline.com/calculator.asmx";
URL uri = new URL(wsSOAPURL);
URLConnection soapEndpoint = uri.openConnection();
HttpURLConnection httpsoapEndpoint = (HttpURLConnection)soapEndpoint;
ByteArrayOutputStream byteArrayOpSt = new ByteArrayOutputStream();

String SoapInputMessage = $/
<s:Envelope xmlns:s="http://www.w3.org/2003/05/soap-envelope">
  <s:Body>
    <Add xmlns="http://tempuri.org/">
      <intA>1</intA>
      <intB>1</intB>
    </Add>
  </s:Body>
</s:Envelope>
/$;
println "INPUT:" +SoapInputMessage
byte [] byteArr = new byte [SoapInputMessage.length()];
byteArr = SoapInputMessage.getBytes();
byteArrayOpSt.write(byteArr);
byte[] b= byteArrayOpSt.toByteArray();
String soapAction ="http://www.dneonline.com/calculator.asmx?op=Add";

httpsoapEndpoint.setRequestProperty("Content-Length", String.valueOf(b.length));
httpsoapEndpoint.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
httpsoapEndpoint.setRequestProperty("SOAPAction", "");
httpsoapEndpoint.setRequestMethod("POST");
httpsoapEndpoint.setRequestProperty("Host", "www.dneonline.com");
httpsoapEndpoint.setDoOutput(true);
httpsoapEndpoint.setDoInput(true);
httpsoapEndpoint.setReadTimeout(5000);
httpsoapEndpoint.connect();
OutputStream soapOutputStream = httpsoapEndpoint.getOutputStream();
//Write the content of the request to the outputstream of the HTTP Connection.
soapOutputStream.write(b);
soapOutputStream.close();
//Ready with sending the request.
//Read the response.
println "Status code :" +httpsoapEndpoint.getResponseCode()
if(httpsoapEndpoint.getResponseCode()==200) {
	InputStreamReader isr = new InputStreamReader(httpsoapEndpoint.getInputStream());

	BufferedReader br = new BufferedReader(isr)
	String linet,line;
	//br.println()
	while((line = br.readLine())!=null) {
		linet= linet+line;
	}
	println "OUTPUT:" +linet

}else {
	httpsoapEndpoint.getErrorStream()
}