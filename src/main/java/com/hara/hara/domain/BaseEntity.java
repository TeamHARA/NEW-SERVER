package com.hara.hara.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동으로 저장됨
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate // Entity의 값을 변경할 때 시간이 자동으로 저장된다.
    private LocalDateTime updated_at;
}