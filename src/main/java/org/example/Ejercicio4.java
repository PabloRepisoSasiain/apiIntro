package org.example;

import javax.xml.soap.*;

public class Ejercicio4 {

    private  static final String ENPOINT_DEFAULT = "http://websamples.countryinfo/CountryInfoService.wso";

    public void countryName (String isoPais) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement operacion = soapBody.addChildElement("CountryName", "", "http://www.oorsprong.org/websamples.countryinfo");
            SOAPElement isoCode = operacion.addChildElement("sCountryISOCode");
            isoCode.addTextNode(isoPais);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, ENPOINT_DEFAULT);
            SOAPBody responseBody = soapResponse.getSOAPBody();
            SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName("CountryNameResponse").item(0);
            String resultado = responseElement.getTextContent();
            System.out.println("El pais es: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void countryLanguage (String isoPais) {
        try{
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement operacion = soapBody.addChildElement("LanguageName","","http://www.oorsprong.org/websamples.countryinfo");
            SOAPElement isoCode = operacion.addChildElement("sISOCode");
            isoCode.addTextNode(isoPais);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, ENPOINT_DEFAULT);
            SOAPBody responseBody = soapResponse.getSOAPBody();
            SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName("LanguageNameResponse ").item(0);
            String resultado = responseElement.getTextContent();
            System.out.println("El pais es: " + resultado);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void countryFullInfo (String isoPais) {
        try{
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement operacion = soapBody.addChildElement("FullCountryInfo","","http://www.oorsprong.org/websamples.countryinfo");
            SOAPElement isoCode = operacion.addChildElement("sCountryISOCode");
            isoCode.addTextNode(isoPais);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, ENPOINT_DEFAULT);
            SOAPBody responseBody = soapResponse.getSOAPBody();
            SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName("FullCountryInfoResponse").item(0);
            String resultado = responseElement.getTextContent();
            System.out.println("La información del pais es: " + resultado);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void countryCurrency (String isoPais) {
        try{
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement operacion = soapBody.addChildElement("CountryCurrency","","http://www.oorsprong.org/websamples.countryinfo");
            SOAPElement isoCode = operacion.addChildElement("sCountryISOCode");
            isoCode.addTextNode(isoPais);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, ENPOINT_DEFAULT);
            SOAPBody responseBody = soapResponse.getSOAPBody();
            SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName("CountryCurrencyResponse").item(0);
            String resultado = responseElement.getTextContent();
            System.out.println("La currency del pais es: " + resultado);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}

