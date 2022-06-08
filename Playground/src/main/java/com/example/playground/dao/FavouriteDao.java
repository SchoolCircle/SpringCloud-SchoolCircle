package com.example.playground.dao;

import com.example.playground.entity.Favourite;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface FavouriteDao {
    int addFavourite(Favourite favourite);

    int countFavouriteNumByTid(Integer tid);

    boolean checkIsFavourite(Favourite favourite);

    int addFavouriteUpdate(Favourite favourite);

    int delFavourite(Favourite favourite);

    //查找某个人的收藏列表
    List<Favourite> findFavouriteByUid(Integer uid);
}
