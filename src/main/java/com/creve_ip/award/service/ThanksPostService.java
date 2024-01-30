package com.creve_ip.award.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creve_ip.award.entity.ThanksPost;
import com.creve_ip.award.repository.ThanksPostRepository;

@Service
public class ThanksPostService {

    private final ThanksPostRepository thanksPostRepository;

    @Autowired
    public ThanksPostService(ThanksPostRepository thanksPostRepository) {
        this.thanksPostRepository = thanksPostRepository;
    }

    public List<ThanksPost> getAllThanksPosts() {
        return thanksPostRepository.findAll();
    }
    
    public void save(ThanksPost thanksPost) {
        thanksPostRepository.save(thanksPost);
    }
}
