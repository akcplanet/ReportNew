package com.merck.sda.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.merck.sda.dao.ReportDAO;
import com.merck.sda.domain.Historical;
import com.merck.sda.domain.Ownership;
import com.merck.sda.domain.Snapshot;
import com.merck.sda.domain.UserAccess;
import com.merck.sda.dto.HistoricalDTO;
import com.merck.sda.dto.OwnershipDTO;
import com.merck.sda.dto.SnapshotDTO;
import com.merck.sda.dto.UserAccessDTO;

@Component("reportservice")
public class ReportService extends BaseService {

	private static final Log log = LogFactory.getLog(ReportService.class);
	@Autowired
	private ReportDAO reportDAO;

	public List<Historical> getHistoricalDetails(HistoricalDTO historicalDTO, Date dFrom, Date dTo) {
		return reportDAO.getHistoricalDetails(historicalDTO, dFrom, dTo);
	}

	public List<Ownership> getOwnershipDetails(OwnershipDTO ownershipDTO, Date dFrom, Date dTo) {
		return reportDAO.getOwnershipDetails(ownershipDTO, dFrom, dTo);
	}

	public List<Snapshot> getSnapshotDetails(SnapshotDTO snapshotDTO, Date dFrom, Date dTo) {
		return reportDAO.getSnapshotDetails(snapshotDTO, dFrom, dTo);
	}

	public List<UserAccess> getUserAccessDetails(UserAccessDTO userAccessDTO, Date dFrom, Date dTo) {
		return reportDAO.getUserAccessDetails(userAccessDTO, dFrom, dTo);
	}

}
