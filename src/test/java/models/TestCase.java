package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    @EqualsAndHashCode.Exclude
    private int id;
    private String title;

    @EqualsAndHashCode.Exclude
    @SerializedName(value = "project_id")
    private int projectID;
}
