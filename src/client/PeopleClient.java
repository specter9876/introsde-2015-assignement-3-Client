package client;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.*;

import introsde.assignment.soap.*;
import javax.xml.namespace.QName;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PeopleClient{
	public static void main(String[] args) throws Exception {
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
       
        JAXBContext jc = JAXBContext.newInstance("introsde.assignment.soap");
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	
		System.out.println("SOAP: https://infinite-garden-2438.herokuapp.com/ws/people?wsdl");
		
		
        System.out.println("///////////////////////METHOD#1//////////////////////////");
        List<Person> plist = people.readPersonList();
        for(Person person: plist){
        	
        	
        	try {
				JAXBElement<Person> personfinal = new JAXBElement<Person>(new QName(
						"http://soap.assignment.introsde/", "person"),
						Person.class, person);
				m.marshal(personfinal, System.out);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
        	
        }
        
        
        ////Method #2 ReadPerson()
        System.out.println("///////////////////////METHOD#2//////////////////////////");
        
        Person p = people.readPerson(1L);
        try {
			JAXBElement<Person> personfinal = new JAXBElement<Person>(new QName(
					"http://soap.assignment.introsde/", "person"),
					Person.class, p);
			m.marshal(personfinal, System.out);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
        
        /////Method #3 updatePerson()
        System.out.println("///////////////////////METHOD#3//////////////////////////");
        
        p.setName("name changed");
        Person updateperson= people.updatePerson(p);
        
        try {
			JAXBElement<Person> personfinal = new JAXBElement<Person>(new QName(
					"http://soap.assignment.introsde/", "person"),
					Person.class, updateperson);
			m.marshal(personfinal, System.out);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
        
        
        
        
        /////Method #4 createPerson()
        System.out.println("///////////////////////METHOD#4//////////////////////////");
        Person newperson=new Person();
        newperson.setName("Kristian");
        newperson.setLastname("Segnana");//add more stuff
        
       /* LifeStatus lftosave1=new LifeStatus();
        MeasureDefinition mdef1=new MeasureDefinition();
        mdef1.setMeasureName("weight");
        mdef1.setIdMeasureDef(1);
        mdef1.setMeasureType("double");
        lftosave1.setMeasureDefinition(mdef1);
        lftosave1.setValue("100");
        List<LifeStatus> listlf=new ArrayList <LifeStatus>();
        listlf.add(lftosave1);
        newperson.setLifeStatus(listlf);*/
        Person personcreate=people.createPerson(newperson);
        int id=personcreate.getIdPerson();
        
        try {
			JAXBElement<Person> personfinal = new JAXBElement<Person>(new QName(
					"http://soap.assignment.introsde/", "person"),
					Person.class,personcreate);
			m.marshal(personfinal, System.out);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
        
        
        
        ////Method #5 deletePerson()
        System.out.println("///////////////////////METHOD#5//////////////////////////");
         Long id2=new Long(id);
         int op= people.deletePerson(id2);
         if(op==0){
        	 System.out.println("Person id:"+id+" Delete OK");
         }
         else{
        	 System.out.println("Person id:"+id+" Delete FAIL");
        	 
         }
        
        /////Method #6 readPersonHistory()
        System.out.println("///////////////////////METHOD#6//////////////////////////");
        
        List<HealthMeasureHistory> healthmeasurehistorylist =people.readPersonHistory(1L, "weight");
        for(HealthMeasureHistory measurehistory: healthmeasurehistorylist){
        	
        	try {
        		JAXBElement<HealthMeasureHistory> measureHistoryfinal = new JAXBElement<HealthMeasureHistory>(new QName("http://soap.assignment.introsde/", "HealthMeasureHistory"),HealthMeasureHistory.class,measurehistory);
        		m.marshal( measureHistoryfinal, System.out);
        	} catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("error");
        	}
        	
        } 
        	
        
        ////Method #7 ReadMeasureTypes()
        System.out.println("///////////////////////METHOD#7//////////////////////////");
        List <MeasureDefinition> measurelist= new ArrayList <MeasureDefinition> (people.readMeasureTypes());
        for(MeasureDefinition measure: measurelist){
        	try {
        		JAXBElement<MeasureDefinition> personfinal = new JAXBElement<MeasureDefinition>(new QName("http://soap.assignment.introsde/", "measureDefinition"),MeasureDefinition.class, measure);
        		m.marshal(personfinal, System.out);
        	} catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("error");
        	}
        } 
        
       
        ////Method #8 readPersonMeasure()
        System.out.println("///////////////////////METHOD#8//////////////////////////");
        
        HealthMeasureHistory hm=people.readPersonMeasure(1L, "weight", 1L);
        try {
        	JAXBElement<HealthMeasureHistory> personfinal = new JAXBElement<HealthMeasureHistory>(new QName("http://soap.assignment.introsde/", "HealthMeasureHistory"),HealthMeasureHistory.class, hm);
        	m.marshal(personfinal, System.out);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("error");
        }	
	
	
        
       
        
        
        
        ////////Method #9 savePersonMeasure()
        System.out.println("///////////////////////METHOD#9//////////////////////////");
        
        LifeStatus lftosave=new LifeStatus();
        MeasureDefinition mdef=new MeasureDefinition();
        mdef.setMeasureName("weight");
        mdef.setIdMeasureDef(1);
        mdef.setMeasureType("double");
        lftosave.setMeasureDefinition(mdef);
        lftosave.setValue("100");
        //lftosave.se;
        
        LifeStatus lf= people.savePersonMeasure(1L, lftosave);
        try {
        	JAXBElement<LifeStatus> personfinal = new JAXBElement<LifeStatus>(new QName("http://soap.assignment.introsde/", "LifeStatus"),LifeStatus.class, lf);
        	m.marshal(personfinal, System.out);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("error");
        }	
	
        
        
        ///////Method #10 updatePersonMeasure()
        System.out.println("///////////////////////METHOD#10//////////////////////////");
        
       HealthMeasureHistory hmh=people.readPersonMeasure(1L, "weight", 1L);
       hmh.setValue("9999");
       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       Date date = new Date();
       hmh.setTimestamp(dateFormat.format(date));
       HealthMeasureHistory finalhlh=people.updatePersonMeasure(1L, hmh);
       try {
    	   JAXBElement<HealthMeasureHistory> personfinal = new JAXBElement<HealthMeasureHistory>(new QName("http://soap.assignment.introsde/", "HealthMeasureHistory"),HealthMeasureHistory.class, finalhlh);
    	   m.marshal(personfinal, System.out);
       	
       } catch (Exception e) {
    	   e.printStackTrace();
    	   System.out.println("error");
       }	
       System.out.println("//////////////END OF CLIENT//////////////////");
    }
}