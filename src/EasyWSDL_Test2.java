
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.ow2.easywsdl.extensions.sawsdl.SAWSDLFactory;
import org.ow2.easywsdl.extensions.sawsdl.api.SAWSDLReader;
import org.ow2.easywsdl.schema.api.Element;
import org.ow2.easywsdl.schema.api.Schema;
import org.ow2.easywsdl.schema.api.Type;
import org.ow2.easywsdl.schema.api.absItf.AbsItfType;
import org.ow2.easywsdl.schema.api.extensions.NamespaceMapperImpl;
import org.ow2.easywsdl.wsdl.WSDLFactory;
import org.ow2.easywsdl.wsdl.api.Description;
import org.ow2.easywsdl.wsdl.api.InterfaceType;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.ow2.easywsdl.wsdl.api.Service;
import org.ow2.easywsdl.wsdl.api.WSDLException;
import org.ow2.easywsdl.wsdl.api.WSDLReader;
import org.ow2.easywsdl.wsdl.impl.wsdl20.InterfaceTypeImpl;
import org.ow2.easywsdl.wsdl.impl.wsdl20.OperationImpl;


public class EasyWSDL_Test2 {


	public static void main(String[] args) throws WSDLException, MalformedURLException, IOException, URISyntaxException {
		WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
		Description desc = reader.read(new URL("http://www.w3schools.com/webservices/tempconvert.asmx?WSDL"));
		
		List<InterfaceType> interfaces = desc.getInterfaces();
		
		Operation operation = interfaces.get(0).getOperations().get(0);
		
		String operationName  = operation.getQName().getLocalPart();
		String operationInput = operation.getInput().getMessageName().getLocalPart();
		String operationOutput = operation.getOutput().getMessageName().getLocalPart();
		
		
		
		
		List<Schema> schemas = desc.getTypes().getSchemas();
		List<Element> Elements = schemas.get(0).getElements();
		String inputName  = Elements.get(0).getQName().getLocalPart();
		String outputName = Elements.get(1).getQName().getLocalPart();
		AbsItfType inputType  = Elements.get(0).getType();//.getQName().getLocalPart();
		AbsItfType outputType = Elements.get(1).getType();
		
		List<Service> Services = desc.getServices();
		
		System.out.print("The operation name is " + operationName + " takes an input called \"" + inputName + "\" and returns and output called \"" + outputName+ "\"");
		
		////////////////////////////////
		
		long startTime = System.currentTimeMillis();
		
		SAWSDLReader sreader = SAWSDLFactory.newInstance().newSAWSDLReader();
		org.ow2.easywsdl.extensions.sawsdl.api.Description sdesc = sreader.read(new URL("http://www.w3.org/2002/ws/sawsdl/spec/wsdl/order#"));
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime+" msec");
		
		int x=0;
	}

}
