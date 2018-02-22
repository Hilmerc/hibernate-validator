/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.constraintvalidators.hv.age.min;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;

/**
 * Checks that the number of Years, Days, Months, etc. according to an unit {@code java.time.temporal.ChronoUnit}
 * from a given {@code java.time.Year} to current day is greater than or equal to the specified value if inclusive is true
 * or is greater when inclusive is false.
 *
 * @author Hillmer Chona
 * @since 6.0.8
 */
public class AgeMinValidatorForYear extends AbstractAgeMinTimeBasedValidator<Year> {

	@Override
	protected Year getReferenceValue(Clock reference, int referenceAge, ChronoUnit unit) {
		return Year.from( LocalDateTime.now( reference ).minus( referenceAge, unit ) );
	}


}