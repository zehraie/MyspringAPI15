package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
public class DebitAccount extends Account {

    private BigDecimal overDraftFee;
}
