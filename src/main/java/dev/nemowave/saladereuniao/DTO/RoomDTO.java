package dev.nemowave.saladereuniao.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    private LocalDate date;

    @NotEmpty
    private LocalDateTime startHour;

    @NotEmpty
    private LocalDateTime endHour;
}
