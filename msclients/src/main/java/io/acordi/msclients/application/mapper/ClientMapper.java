package io.acordi.msclients.application.mapper;

import io.acordi.msclients.application.dto.ClientRequestDTO;
import io.acordi.msclients.application.exception.InvalidStructureException;
import io.acordi.msclients.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "birthday", source = "birthday", qualifiedByName = "convertStringToDate")
    Client toClient(ClientRequestDTO dto);

    @Named("convertStringToDate")
    default LocalDate convertStringToDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }

        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),    // ISO format
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),    // Common European format
                DateTimeFormatter.ofPattern("MM/dd/yyyy")     // Common US format
        );

        for (DateTimeFormatter formatter : formatters) {
            LocalDate date = parseDate(dateStr, formatter);
            if (date != null) {
                return date;
            }
        }

        throw new InvalidStructureException(
                "The given date is in an unsupported format. Please use one of the following formats: yyyy-MM-dd, dd/MM/yyyy, MM/dd/yyyy."
        );
    }

    private LocalDate parseDate(String dateStr, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null; // Ignore and try the next formatter
        }
    }


}
