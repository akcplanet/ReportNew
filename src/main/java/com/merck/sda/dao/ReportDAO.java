package com.merck.sda.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.merck.sda.domain.Historical;
import com.merck.sda.domain.Ownership;
import com.merck.sda.domain.Snapshot;
import com.merck.sda.domain.UserAccess;
import com.merck.sda.dto.HistoricalDTO;
import com.merck.sda.dto.OwnershipDTO;
import com.merck.sda.dto.SnapshotDTO;
import com.merck.sda.dto.UserAccessDTO;

@Repository("reportdao")
public class ReportDAO extends BaseDAO {
	
	
	
	public List<Historical> getHistoricalDetails(HistoricalDTO historicalDTO,Date dFrom, Date dTo) {
		List<Historical> output= new ArrayList<Historical>();
		Historical hst1= new Historical();
		Historical hst2= new Historical();
		hst1.setServername("\\bardsar");
		hst1.setFoldername("'\'mk0859-lipids'\'prot058-datasourceextract");
		hst1.setUserISID("VAIDYA");
		hst1.setDateStatus("12/26/2016 08:20:02");
		hst1.setType("Remove All Access - ISID Notified");
		
		hst2.setServername("BEBRFP003");
		hst2.setFoldername("'\'mk0518-hiv'\'prot812");
		hst2.setUserISID("SAHUKR");
		hst2.setDateStatus("12/26/2016 08:20:02");
		hst2.setType("Read/Write (Change)");
		
		output.add(hst1);
		output.add(hst2);
		return output;
	}
	
	
	public List<Ownership> getOwnershipDetails(OwnershipDTO ownershipDTO,Date dFrom, Date dTo) {
		List<Ownership> output= new ArrayList<Ownership>();
		Ownership owner1= new Ownership();
		Ownership owner2= new Ownership();
		owner1.setTypeid("602");
		owner1.setServername("1_Partnernet");
		owner1.setFoldername("DModel_IT_Group");
		owner1.setOwnerISID("nazariad");
		owner1.setOwnershiptype("primary");
		
		
		owner2.setTypeid("601");
		owner2.setServername("'\\'BEDATA002'\'");
		owner2.setFoldername("PSCS_OSS_ODF");
		owner2.setOwnerISID("Rissen");
		owner2.setOwnershiptype("Back-up");
		
		output.add(owner1);
		output.add(owner2);
		return output;
	}
	
	
	public List<Snapshot> getSnapshotDetails(SnapshotDTO snapshotDTO,Date dFrom, Date dTo) {
		List<Snapshot> output= new ArrayList<Snapshot>();
		Snapshot snap1= new Snapshot();
		Snapshot snap2= new Snapshot();
		snap1.setTypeid("600");
		snap1.setServername("bardsar");
		snap1.setFoldername("'\'mk0431-diabetes'\'p082");
		snap1.setUserISID("YEEK");
		snap1.setType("Remove All Access");
		snap1.setDateuseradded("12/06/2016 12:45:09");
		snap1.setUseraddedCPI("12/06/2016 12:45:00");
		snap1.setUsername("Yee, Kelly (KA LAI)");
		snap1.setEmailaddress("ka_yee@merck.com");
		snap1.setTitle("Prin. Scientist, Quant. Sciences");
		snap1.setDepartment("PPDM QP2 Neuroscience");
		snap1.setManager("CN=Macha'\', Sreeraj (machas), OU=eCore, Office, OU=People Accounts,DC=merck, DC=com");
		
		snap2.setTypeid("601");
		snap2.setServername("\\bardsar-prod");
		snap2.setFoldername("\ta-std-macros");
		snap2.setUserISID("Manolia");
		snap2.setType("Read Only");
		snap2.setDateuseradded("12/12/2016 11:50:51");
		snap2.setUseraddedCPI("08/07/2015 07:55:01");
		snap2.setUsername("Manoli, Akshay D(manolia)");
		snap2.setEmailaddress("akshay.manoli@merck.com");
		snap2.setTitle("Partner");
		snap2.setDepartment("AMS Clinical Research and Pipeline Mgmt");
		snap2.setManager("CN=Pulugura'\', Gayatri, OU=eCore, Office, OU=People Accounts,DC=merck, DC=com");
		
		output.add(snap1);
		output.add(snap2);
		return output;
	}
	
	
	public List<UserAccess> getUserAccessDetails(UserAccessDTO userAccessDTO,Date dFrom, Date dTo) {
		List<UserAccess> output= new ArrayList<UserAccess>();
		UserAccess ua1= new UserAccess();
		UserAccess ua2= new UserAccess();
		
		ua1.setServername("\\ATVIDATA001");
		ua1.setFoldername("'\'ATVI_Medical");
		ua1.setReadtypeandisid("Read Only : shenliji");
		ua1.setReadwritetypeandisid("Read/Write : kulkarnt; zhuhong4; ghosalka; zhangj22; weizi; zhaoyi");
		
		
		ua2.setServername("\\bardsar-test");
		ua2.setFoldername("'\'mk3475-nsclc'\'prot 189-ia1");
		ua2.setReadtypeandisid("Read Only : zhuhong4");
		ua2.setReadwritetypeandisid("Read/Write : shenliji; zhuhong4");
		
		output.add(ua1);
		output.add(ua2);
		return output;
	}
	
	
/*	
	@SuppressWarnings("unchecked")
	public List<VolunteerDetails> getVolunteerDetail(Date dFrom,  Date dTo) {
		List<VolunteerDetails> listofevents= null;
		Query query = getEntityManager().createQuery("Select vd from VolunteerDetails vd where "
				+ " vd.eventDetails.eventDate >=  :eventDateFrom  and vd.eventDetails.eventDate <=  :eventDateTo")
		.setParameter("eventDateFrom", (dFrom !=null) ? dFrom : null) 
		.setParameter("eventDateTo", (dTo !=null) ? dTo : null) ;		
		listofevents = query.getResultList();
		return listofevents;
	}

	
	@SuppressWarnings("unchecked")
	public List<ReportDetails> getEventDetail(Date dFrom,  Date dTo) {
		List<ReportDetails> listofevents= null;
		Query query = getEntityManager().createQuery("Select ed from ReportDetails ed where "
				+ " ed.eventDate >=  :eventDateFrom  and ed.eventDate <=  :eventDateTo")
				.setParameter("eventDateFrom", (dFrom !=null) ? dFrom : null) 
				.setParameter("eventDateTo", (dTo !=null) ? dTo : null) ;	
		listofevents = query.getResultList();
		return listofevents;
	}
	*/



}
