package JpaST2.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="videos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "VideoId")
	private String videoid;

	@Column(name = "Active")
	private int active;

	@Column(name = "Description", columnDefinition = "nvarchar(500) null")
	private String description;

	@Column(name = "Poster", columnDefinition = "nvarchar(500) null")
	private String poster;

	@Column(name = "Title", columnDefinition = "nvarchar(255) null")
	@NotEmpty(message = "Không được bỏ trống")
	private String title;

	@Column(name = "Views")
	private int views;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	
	
	
}
