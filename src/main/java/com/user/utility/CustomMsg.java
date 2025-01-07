package com.user.utility;

public class CustomMsg {

	public static final String subject = "Important Update: Reset your password";

	public static String emailBody(String password) {
		String message = """
				<html>
				    <body>
				        <p>Dear User,</p>
				        <p>We hope this email finds you well. We are writing to inform you about an important update regarding your account.</p>
				        <p>Please take a moment to review the details and take the necessary actions if required:</p>
				        <ul>
				            <li>Update your profile information.</li>
				            <li>Verify your contact details.</li>
				            <li>Reset Your password</li>
				            <li>@Password-  : <b>"""
				+ password
				+ """
						           </b> </li>

						        </ul>
						        <p>If you have any questions or need further assistance, please do not hesitate to contact our support team.</p>
						        <p>Thank you for your prompt attention to this matter.</p>
						        <br/>
						        <p>Best regards,</p>
						        <p>The Support Team</p>
						    </body>
						</html>
						""";
		return message;
	}

}
