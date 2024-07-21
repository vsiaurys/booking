import "./Footer.css";

export default function Footer() {
  const getCurrentYear = () => {
    const currentDate = new Date();
    const currentYear = currentDate.getFullYear();

    return currentYear;
  };

  return (
    <footer className="mt-auto footer w-100">
      <div className="container text-start p-3 w-100">
        <div className="row">
          <div className="col-sm-1 col-md-8 col-lg-9">
            <ul className="list-unstyled">
              <li>
                <h5>Support</h5>
              </li>
              <li>Help center</li>
              <li>Cancellation options</li>
              <li>Manage your trips</li>
              <li>Loyality program</li>
            </ul>
          </div>

          <div className="col-4 col-sm-6 col-md-4 col-lg-3 d-flex justify-content-end">
            <ul className="list-unstyled">
              <li>
                <h5>Terms and settings</h5>
              </li>
              <li>Terms and conditions</li>
              <li>Privacy & cookies</li>
              <li>List your property</li>
            </ul>
          </div>

          <div className="col-4 col-sm-6 col-md-4 col-lg-3 d-flex justify-content-end">
            <ul className="list-unstyled">
              <li>
                <h5>About</h5>
              </li>
              <li>About HBP</li>
              <li>New features</li>
              <li>Careers</li>
              <li>Investors</li>
            </ul>
          </div>
        </div>
        <div>&#169; {getCurrentYear()} HOTEL BOOKING PLATFORM (HBP)</div>
      </div>
    </footer>
  );
}
