package com.ironmanyg.blood_donation_domain.donationCenter.operationInfo

/**
 * A data class encapsulating the operational details of a blood donation center.
 *
 * It embodies the working hours using a structured time format, a list of operational days,
 * the interlude between appointments, the maximum donor capacity, and a list of available time slots.
 *
 * @property workingHours A pair of SimpleTime instances representing the start
 *                        and end of the working hours. For instance, if the working hours
 *                        are from 9 AM to 5 PM, the pair would be (SimpleTime(9, 0), SimpleTime(17, 0)).
 * @property workingDays A list detailing the specific days of the week when the
 *                       donation center is operational.
 * @property gapBetweenAppointment An integer indicating the time interval (in minutes)
 *                                 between consecutive donor appointments, ensuring efficient
 *                                 donor management.
 * @property donorLimit An integer representing the utmost number of donors the
 *                      center can handle simultaneously or within a day.
 * @property timeSlots A list detailing the explicit time slots during which donors
 *                     can book appointments, aiding in efficient scheduling.
 */
data class OperationInfo(
    val workingHours: Pair<SimpleTime, SimpleTime>,
    val workingDays: List<Day>,
    val gapBetweenAppointment: Int,
    val donorLimit: Int,
    val timeSlots: List<TimeSlot>
)

/**
 * Converts a list of strings representing days (either full names or abbreviations) to a `List<Day>`.
 *
 * This function is designed to be flexible in handling day representations. For instance, both "Monday"
 * and "Mon" will be mapped to [Day.MONDAY]. If a provided string doesn't match any day, it's ignored.
 *
 * @param days A list of strings where each string is a day's full name (e.g., "Monday") or abbreviation (e.g., "Mon").
 * @return A list of [Day] enums corresponding to the provided list of strings.
 */
fun stringDaysToListOfDays(days: List<String>): List<Day> {
    return days.mapNotNull { dayString ->
        // Check against both full names and abbreviations for days
        when (dayString.lowercase()) {
            "monday", "mon" -> Day.MONDAY
            "tuesday", "tue" -> Day.TUESDAY
            "wednesday", "wed" -> Day.WEDNESDAY
            "thursday", "thu" -> Day.THURSDAY
            "friday", "fri" -> Day.FRIDAY
            "saturday", "sat" -> Day.SATURDAY
            "sunday", "sun" -> Day.SUNDAY
            // If the string doesn't match any day, return null to be filtered out by mapNotNull
            else -> null
        }
    }
}
