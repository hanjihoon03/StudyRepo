package com.impl;

import com.custom.UploadApiRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.base.QUploadFile.uploadFile;


@Repository
public class UploadApiRepositoryImpl implements UploadApiRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    public UploadApiRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     *  아이템 삭제에 연계되어 삭제될 파일을 삭제합니다.
     * @param itemId 삭제될 아이템의 id
     */
    @Override
    public void deleteFromItemId(Long itemId) {
        queryFactory.delete(uploadFile)
                .where(uploadFile.item.id.eq(itemId));
    }


}
