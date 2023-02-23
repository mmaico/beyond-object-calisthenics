package examples.repository.teachers.certification.domain.model.certificatiion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Expired extends Date {


    public Boolean isOverdue() {
        var today = new Date();
        return this.before(today);
    }

    public long howManyDaysUntilExpiration() {
        var now = LocalDate.now();
        var due = this.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Duration.between(now.atStartOfDay(), due.atStartOfDay()).toDays();
    }
}
