package com.hshop.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.source.doctree.SerialDataTree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "categoties")
public class Category implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long categoryId;

@Column(name = "category_name", length =100, nullable = false, columnDefinition = "nvarchar(100)not null")
private String name;



@OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
private Set<Product> products;
}
