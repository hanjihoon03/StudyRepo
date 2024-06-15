package com.impl;

import com.base.QUploadFile;
import com.base.UploadFile;
import com.custom.FileRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.base.QUploadFile.uploadFile;


@Repository
public class FileRepositoryImpl implements FileRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public FileRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 아이템의 아이디로 아이템과 연관된 이미지 파일을 찾습니다.
     * @param id 아이템의 id
     * @return 아이템 id의 UploadFile 반환
     */

    @Override
    public UploadFile findByItemId(Long id) {
        return queryFactory.select(uploadFile)
                .from(uploadFile)
                .where(uploadFile.item.id.eq(id)).fetchOne();
    }
    @Override
    public void deleteFromItemId(Long id) {
        queryFactory.delete(uploadFile)
                .where(uploadFile.item.id.eq(id))
                .execute();
    }
}
