export default function verifyEmailFormat(email) {
  const emailFormatRegex = new RegExp(".*@.*\\..*");
  return emailFormatRegex.test(email);
}
