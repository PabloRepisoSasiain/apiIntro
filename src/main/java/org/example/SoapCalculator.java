package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.soap.*;

@SuppressWarnings("unused")
public class SoapCalculator {

    private static final String ENDPOINT = "http://dneonline.com/calculator.asmx";

    public String calculadoraSoap (String operation,int intA,int intB,String response){
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPElement operationElement = soapBody.addChildElement(operation, "", "http://tempuri.org/");
            SOAPElement intAElement = operationElement.addChildElement("intA");
            intAElement.addTextNode(String.valueOf(intA));
            SOAPElement intBElement = operationElement.addChildElement("intB");
            intBElement.addTextNode(String.valueOf(intB));
            SOAPMessage soapResponse = soapConnection.call(soapMessage, ENDPOINT);
            SOAPBody responseBody = soapResponse.getSOAPBody();
            SOAPElement responseElement;
            if(responseBody.getElementsByTagName(response).getLength()>0){
                responseElement = (SOAPElement) responseBody.getElementsByTagName(response).item(0);
            }else if(operation.equals("Divide") && intB == 0){
                throw new RuntimeException("No se puede dividir entre 0");
            }else{
                throw new RuntimeException();
            }
            String resultado = responseElement.getTextContent();
            System.out.println("El valor resultadao es: " + resultado);
            soapConnection.close();
            return resultado;
        } catch (Exception e) {
            if(e.getMessage().equals("No se puede dividir entre 0")){
                throw new RuntimeException("Erorr al dividir entre 0");
            }
            return null;
        }
    }

    @Test
    @DisplayName("CalculadoraSoapAddTest")
    public void testSoapCalculatorAddTest (){
        String value = calculadoraSoap("Add",5,10, "AddResponse");
        assertEquals(value,"15");
        assertNotNull(value);
        assertTrue(Integer.valueOf(value)>14);
        assertFalse(Integer.valueOf(value)>16);
    }

    @Test
    @DisplayName("CalculadoraSoapDivideTest")
    public void testSoapCalculatorDivideTest (){
        String value = calculadoraSoap("Divide",10,2,"DivideResponse");
        assertEquals(value,"5");
        assertNotNull(value);
        assertTrue(Integer.valueOf(value)>4);
        assertFalse(Integer.valueOf(value)>6);
    }

    @Test
    @DisplayName("CalculadoraSoapDivide0Test")
    public void testSoapCalculatorDivide0Test (){
        assertThrows(RuntimeException.class,()->{
            calculadoraSoap("Divide",10,0,"DivideResponse");
        });
    }

    @Test
    @DisplayName("CalculadoraSoapMultiplyTest")
    public void testSoapCalculatorMultiplyTest (){
        String value = calculadoraSoap("Multiply",2,4,"MultiplyResponse");
        assertEquals(value,"8");
        assertNotNull(value);
        assertTrue(Integer.valueOf(value)>7);
        assertFalse(Integer.valueOf(value)>9);
    }

    @Test
    @DisplayName("CalculadoraSoapSubtractTest")
    public void testSoapCalculatorSubtractTest (){
        String value = calculadoraSoap("Subtract",45,45,"SubtractResponse");
        assertEquals(value,"0");
        assertNotNull(value);
        assertTrue(Integer.valueOf(value)>-1);
        assertFalse(Integer.valueOf(value)>5);
    }


}
