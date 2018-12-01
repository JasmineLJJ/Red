package com.red.service;

import com.red.domain.entity.CrawlingHistoryDO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Liujunjie on 2018/12/1.
 */
public class CrawlingHistoryService {
    private SequenceService sequenceService;
    private SessionFactory sessionFactory;

    public List<CrawlingHistoryDO> getLatestCrawlingHisotry() {
        Long crawlingHistorySequence = sequenceService.getCrawlingHistorySequenceValue();
        String query = "select * from CRAWLINGHISTORY where VERSION = : version";
        List<CrawlingHistoryDO> crawlingHistoryDOs = sessionFactory.getCurrentSession()
                                                                    .createQuery(query, CrawlingHistoryDO.class)
                                                                    .setParameter("version", crawlingHistorySequence)
                                                                    .list();
        return crawlingHistoryDOs;
    }

    public void setSequenceService(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
