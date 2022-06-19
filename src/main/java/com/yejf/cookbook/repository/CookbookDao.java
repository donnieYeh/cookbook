package com.yejf.cookbook.repository;

import com.yejf.cookbook.model.CookBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CookbookDao {
    @Insert("insert into cookbook(name, `desc`, url, session, day_of_week, period_of_day) " +
            "values " +
            "(#{dish.name},#{dish.desc},#{dish.url}," +
            "#{session},#{dayOfWeek},#{periodOfDay})")
    public void save(CookBook cookBook);

    @Delete("delete from cookbook where id = #{id}")
    public void remove(@Param("id") int id);

    @Select("select *\n" +
            "from cookbook c\n" +
            "where c.session = #{session}\n" +
            "  and c.day_of_week = #{dayOfWeek}\n" +
            "  and c.period_of_day = #{periodOfDay}")
    @Results({
            @Result(column = "name",property = "dish.name"),
            @Result(column = "desc",property = "dish.desc"),
            @Result(column = "url",property = "dish.url"),
            @Result(column = "day_of_week",property = "dayOfWeek"),
            @Result(column = "period_of_day",property = "periodOfDay"),
    })
    public List<CookBook> search(CookBook query);
}
