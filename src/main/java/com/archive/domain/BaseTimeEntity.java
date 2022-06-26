package com.archive.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 해당 클래스를 상속받을 경우, 해당 클래스의 필드들도 컬럼으로 인식함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    
    @CreatedDate // Entity 최초 생성될 때 시간 자동 저장
    private LocalDateTime createdDate;
    
    @LastModifiedDate // 수정될 때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
