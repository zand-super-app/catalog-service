package ae.superapp.catalog.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CREATED_AT")
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "LAST_MODIFIED_AT")
	@LastModifiedDate
	private LocalDateTime lastModifiedAt;
	
}
