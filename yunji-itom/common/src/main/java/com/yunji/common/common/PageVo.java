package com.yunji.common.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 9:34
 * @Modified:
 **/
@Data
public class PageVo<T> {
    /**
     * 每页显示大小
     * 默认大小：10
     */
    private long  pageSize = 10;

    /**
     * 当前页码
     * 默认：1
     */
    private  long currentPage = 1;

    /**
     * 最大页数
     */
    private  long totalPage;

    /**
     * 数据总条数
     */
    private  long totalRecords;

    /**
     * 数据
     */
    private List<T> records;

    public void setTotal(long totalRecords) {
        if(pageSize != 0){
            if(totalRecords % pageSize != 0){
                totalPage = totalRecords / pageSize + 1;
            }else {
                totalPage = totalRecords / pageSize;
            }
        }
    }

    public PageVo() {

    }
    public PageVo(IPage<T> page) {
        this.currentPage = page.getCurrent() ;
        this.pageSize = page.getSize() ;
        this.totalRecords = page.getTotal() ;
        setTotal(page.getTotal());
        this.records = page.getRecords() ;

    }


    public PageVo(long pageSize, long currentPage, long totalRecords) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecords = totalRecords;
        setTotal(totalRecords);
    }
}
