package com.disney.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatterBuilder;

public class DateAndTime {
	/* To get the Current Time */
	public static String getTime() throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("kk.mm");
		String TimeNow = dateFormat.format(date);
		return TimeNow;
	}

	/* To get the Current Date */
	public static String getDate() throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String DateNow = dateFormat.format(date);
		return DateNow;
	}

	public static String getDateMMDDYYYFormat(String newdate) throws Exception {
		// Date date = new Date();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(newdate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		String DateNow = dateFormat.format(date1);
		return DateNow;
	}

	public static String getSpecifiedDateFormat(String newdate, String format) throws Exception {
		// Date date = new Date();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(newdate);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String DateNow = dateFormat.format(date1);
		return DateNow;
	}

	public static String searchAiringShowFormat(String date, String name, String fullDetails) throws Exception {
		// String date = "03/22/2020";

		String formartendtime = fullDetails.split(",")[3].trim().split("-")[0];
		if (formartendtime.length() == 5) {
			formartendtime = "0" + formartendtime;
			System.out.println(formartendtime);
		} else {
			System.out.println(formartendtime);
		}
		formartendtime = formartendtime.replaceFirst("^ *", "");

		System.out.println(date + "," + formartendtime + "," + name);
		return date + "," + formartendtime + "," + name;

	}

	public static String getDateFallsOnWeekday(String date, int dayCountToAdd) throws Exception {

		date = getCustomFutureDate(date, dayCountToAdd);// generateDate(30);

		int month = Integer.parseInt(date.split("/")[0]);
		int weekDay = Integer.parseInt(date.split("/")[1]);
		int year = Integer.parseInt(date.split("/")[2]);

		LocalDate startDate = new LocalDate(year, month, weekDay);
		int day = startDate.dayOfWeek().get(); // gets the day of the week as integer

		String dateFormat = year + "-" + month + "-" + weekDay;
		if (DateTimeConstants.SUNDAY == day) {
			date = getCustomFutureDate(dateFormat, 1);// generateDate(1);
		} else if (DateTimeConstants.SATURDAY == day) {
			date = getCustomFutureDate(dateFormat, 2);// generateDate(2);
		}

		System.out.println(date + " date");
		return date;
	}

	public static String getCustomFutureDate(String oldDate, int dayCountToAdd) throws Exception {
		// oldDate = "2020-03-10";
		System.out.println("Date before Addition: " + oldDate);
		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, dayCountToAdd);
		// Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition: " + newDate);

		String dateNow = getSpecifiedDateFormat(newDate, "MM/dd/yyyy");

		System.out.println("Final: " + dateNow);
		return dateNow;
	}

	/* To get the Current Month in Integer */
	public static int getMonth_Integer() throws Exception {
		DateTime datetime = DateTime.now();
		int month = datetime.getMonthOfYear();
		return month;
	}

	/* To get the Current Month Text as Full in String */
	public static String getMonth_Full() throws Exception {
		DateTime datetime = DateTime.now();
		String month_Full = datetime.monthOfYear().getAsText();
		return month_Full;
	}

	/* To get the Current Month Text as Short in String */
	public static String getMonth_Short() throws Exception {
		DateTime datetime = DateTime.now();
		String month_Short = datetime.monthOfYear().getAsShortText();
		return month_Short;
	}

	/* To get the Current Day of the Month */
	public static String getDayOfTheMonth() throws Exception {
		DateTime datetime = DateTime.now();
		String dayOfTheMonth = datetime.dayOfMonth().getAsText();
		return dayOfTheMonth;
	}

	/* To get the Current Day Count in the Year */
	public static String getDayCount() throws Exception {
		DateTime datetime = DateTime.now();
		String dayCountYear = datetime.dayOfYear().getAsText();
		return dayCountYear;
	}

	/* To get the Current Minute of the Hour in String */
	public static String getMinuteOfTheHourAsString() throws Exception {
		DateTime datetime = DateTime.now();
		String minuteOfTheHour = datetime.minuteOfHour().getAsText();
		return minuteOfTheHour;
	}

	/* To get the Current Year as Integer */
	public static int getYear() throws Exception {
		DateTime datetime = DateTime.now();
		int year = datetime.getYear();
		return year;
	}

	/* To get the Current Hour of the Day in String */
	public static String getHourOfTheDay() throws Exception {
		DateTime datetime = DateTime.now();
		String hour = datetime.hourOfDay().getAsShortText();
		return hour;
	}

	/* To get the Current Week Count */
	public static String getWeekCount() throws Exception {
		DateTime datetime = DateTime.now();
		String hour = datetime.weekOfWeekyear().getAsText();
		return hour;
	}

	public static String substractTime(String time, long mins, String datatoEnter) {

		org.joda.time.format.DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendHourOfDay(2)
				.appendLiteral(":").appendMinuteOfHour(2).appendLiteral(" ").appendHalfdayOfDayText().toFormatter();
		LocalTime start = LocalTime.parse(time, dtf);
		LocalTime end = start.minusMinutes(15);
		System.out.println(start.toString("hh:mm a") + " to " + end.toString("hh:mm a"));
		String substractedTime = end.toString("hh:mm a");
		substractedTime.replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9_-]", "");
		return substractedTime;
	}

	public static String generateDate(int offset) {
		return convertDate(offset, "MM/dd/yyyy");
	}

	public static String convertDate(int offset, String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, offset);
		return f.format(c.getTime());
	}

	private static String getFormattedDate(Date date) {
		DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
		String Date = outputFormatter.format(date);
		return Date;
	}

	public static String getLastDayOfMonth() {
		Date end;
		{
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			end = calendar.getTime();
		}

		return getFormattedDate(end);
	}

	public static String getFirstDayOfMonth() {
		Date beginning;
		{
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			beginning = calendar.getTime();

		}
		return getFormattedDate(beginning);
	}

}
