export default function verifyEmailFormat(email) {
  const emailFormatRegex = new RegExp(".*@.*\\.(edu)|(com)|(org)|(net)|(gov)");
  return emailFormatRegex.test(email);
}
