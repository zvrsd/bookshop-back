/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cda611
 */
public class OrderStatus implements Serializable {

   
    private static final long serialVersionUID = 1L;
	/*
	 * @Id
	 * 
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "ORDER_STATUS_ID")
	 */
    private Integer orderStatusId;
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "ORDER_STATUS_NAME")
	 */
    private String orderStatusName;
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "ORDER_STATUS_POST_IT")
	 */
    private String orderStatusPostIt;
    private Date date;
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    public OrderStatus() {
    }

    public OrderStatus(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
        this.date = date; 
    }

    public OrderStatus(Integer orderStatusId, String orderStatusName, String orderStatusPostIt) {
        this.orderStatusId = orderStatusId;
        this.orderStatusName = orderStatusName;
        this.orderStatusPostIt = orderStatusPostIt;
        this.date = date;
    }
    
        public OrderStatus( String orderStatusName, String orderStatusPostIt) {

        this.orderStatusName = orderStatusName;
        this.orderStatusPostIt = orderStatusPostIt;
        this.date = date;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public String getOrderStatusPostIt() {
        return orderStatusPostIt;
    }

    public void setOrderStatusPostIt(String orderStatusPostIt) {
        this.orderStatusPostIt = orderStatusPostIt;
    }

    public String getDate(){
        return format.format(date); 
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderStatusId != null ? orderStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.orderStatusId == null && other.orderStatusId != null) || (this.orderStatusId != null && !this.orderStatusId.equals(other.orderStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "librairie.OrderStatus[ orderStatusId=" + orderStatusId + " ]";
    }
    
}