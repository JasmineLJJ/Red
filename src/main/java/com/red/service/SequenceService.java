package com.red.service;

import org.hibernate.SessionFactory;

/**
 * Created by Liujunjie on 2018/12/1.
 */
public class SequenceService {
    private static final String CRAWLING_HISTORY_SEQUENCE = "CRAWLING_HISTORY_SEQUENCE";
    private static final Long CRAWLING_HISTORY_SEQUENCE_ID = 1L;

    private SessionFactory sessionFactory;

    public Long getCrawlingHistorySequenceValue () {
        System.out.println(CRAWLING_HISTORY_SEQUENCE);
        Long seqValue = (Long) sessionFactory.getCurrentSession().createQuery("select VALUE from CRAWLING_HISTORY_SEQUENCE where id = :id" ).setParameter("id", CRAWLING_HISTORY_SEQUENCE).uniqueResult();
        return seqValue;
    }
}
