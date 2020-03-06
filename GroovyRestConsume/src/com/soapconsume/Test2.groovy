package com.soapconsume

//Code to make a webservice HTTP request
String responseString = "";
String outputString = "";
String wsURL = "http://www.dneonline.com/calculator.asmx";
URL url = new URL(wsURL);
URLConnection connection = url.openConnection();
HttpURLConnection httpConn = (HttpURLConnection)connection;
ByteArrayOutputStream bout = new ByteArrayOutputStream();
String xmlInput =$/
<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
  <s:Header>
    <Action s:mustUnderstand="1" xmlns="http://schemas.microsoft.com/ws/2005/05/addressing/none">http://tempuri.org/Add</Action>
  </s:Header>
  <s:Body>
    <Add xmlns="http://tempuri.org/">
      <intA>2</intA>
      <intB>2</intB>
    </Add>
  </s:Body>
</s:Envelope>
/$;
 
byte[] buffer = new byte[xmlInput.length()];
buffer = xmlInput.getBytes();
bout.write(buffer);
byte[] b = bout.toByteArray();
String SOAPAction =
"http://www.dneonline.com/calculator.asmx";
// Set the appropriate HTTP parameters.
httpConn.setRequestProperty("Content-Length",
String.valueOf(b.length));
httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
httpConn.setRequestProperty("SOAPAction", SOAPAction);
httpConn.setRequestMethod("POST");
httpConn.setDoOutput(true);
httpConn.setDoInput(true);
OutputStream out = httpConn.getOutputStream();
//Write the content of the request to the outputstream of the HTTP Connection.
out.write(b);
out.close();
//Ready with sending the request.
 
//Read the response.
InputStreamReader isr =
new InputStreamReader(httpConn.getInputStream());
BufferedReader input = new BufferedReader(isr);
 
//Write the SOAP message response to a String.
while ((responseString = input.readLine()) != null) {
outputString = outputString + responseString;
}