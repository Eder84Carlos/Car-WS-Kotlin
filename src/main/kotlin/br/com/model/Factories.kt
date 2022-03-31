package br.com.model

import javax.persistence.Entity
import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import lombok.Data
import javax.persistence.Table
    import javax.persistence.Id;
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.CascadeType
import javax.persistence.OneToMany
import com.sun.istack.internal.NotNull
import java.util.List

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "factories")
@Entity
class Factories(

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 val id: Long = 0,
	
	@OneToMany(cascade = [CascadeType.ALL])
	val cars: List<Cars>,
	
	@Column(name = "name")
	 var name: String,
	
	@Column(name = "docName")
	 var docName: Byte,
	
	@Column(name = "country_code")
	@NotNull
	 var country_code: String,

	)