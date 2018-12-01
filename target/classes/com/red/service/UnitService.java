package com.red.service;

import com.red.domain.*;
import com.red.domain.entity.SchoolDO;
import com.red.domain.entity.TradingHistoryDO;
import com.red.domain.entity.UnitDO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Liujunjie on 2018/11/11.
 */

public class UnitService {
    private SessionFactory sessionFactory;

    public Long add() {
        TradingHistoryDO tradingHistoryDO = new TradingHistoryDO();
        tradingHistoryDO.setCreatedDate(new Date(1541030400));
        tradingHistoryDO.setPrice(1110000);
        tradingHistoryDO.setMSL("ML81730631");
        tradingHistoryDO.setStatus(UnitStatus.Open);

        UnitDO unitDO = new UnitDO();
        unitDO.setPropertyType(PropertyType.SINGLE);
        unitDO.setUnitNumber(529);
        unitDO.setStreet("Oakwood Dr");
        unitDO.setRedUrl("http://www.redfin.com/CA/Santa-Clara/529-Oakwood-Dr-95054/home/12171031");
        unitDO.setYearBuilt(1994);
        unitDO.setCounty(County.SANTA_CLARA);
        unitDO.setState(State.CA);
        unitDO.setZipcode("95054");
        unitDO.setLatestListingPrice(1198000);
        unitDO.setBeds(4);
        unitDO.setBath(3.0f);
        unitDO.setFinishedSize(1000);
        unitDO.setLotSize(1000);
        unitDO.setMLS("ML81730631");
        unitDO.setCreatedDate(new Date(1541030400));
        unitDO.setLastUpdatedDate(new Date());
        unitDO.setDetailed(false);
        unitDO.setStyle(PropertyStyle.Single);
        unitDO.setStatus(UnitStatus.Open);
        unitDO.setUnitCreatedDate(new Date(1541030400));

        SchoolDO schoolDO1 = new SchoolDO();
        schoolDO1.setSchoolName("Mountain View Elementary School");
        schoolDO1.setGreatSchoolRating(8.0f);
        schoolDO1.setLevel(SchoolLevel.ELEMENTARY);
        schoolDO1.setParentRating(8.0f);

        SchoolDO schoolDO2 = new SchoolDO();
        schoolDO2.setSchoolName("Mountain View Middle School");
        schoolDO2.setGreatSchoolRating(8.0f);
        schoolDO2.setLevel(SchoolLevel.MIDDLE);
        schoolDO2.setParentRating(8.0f);
        unitDO.addSchool(schoolDO1);
        unitDO.addSchool(schoolDO2);

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Long employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Long) session.save(unitDO);
            tradingHistoryDO.setUnitDo(unitDO);
            session.save(tradingHistoryDO);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
