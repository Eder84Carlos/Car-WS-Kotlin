package br.com.model

import javax.persistence.Entity
import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import lombok.Data
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
    import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cars")
@Entity
class Cars(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 val id: Long?,
	
	@ManyToOne // muitos carros para um fabricante
	@JoinColumn(name="factories_id")
	val factories_id: Factories,
	
	@Column(name = "color")
	 var color: String,
	
	@Column(name = "cost")
	 var cost: String,
	
	@Column(name = "doors")
	 var contry_code: String,

	@Column(name = "model")
	 var model: String,

	@Column(name = "year")
	 var year: String,
	)

