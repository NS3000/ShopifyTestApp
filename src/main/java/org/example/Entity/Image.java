package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Images")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Image {

    @Id
    @Column(name = "imageId")
    Long id;
    @Column(name = "imageSource")
    String src;
    @Column(name = "isDeleted", columnDefinition = "boolean default false")
    private Boolean isDel=false;

}
