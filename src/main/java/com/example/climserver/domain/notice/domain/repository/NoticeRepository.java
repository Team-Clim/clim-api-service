package com.example.climserver.domain.notice.domain.repository;

import com.example.climserver.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
}
