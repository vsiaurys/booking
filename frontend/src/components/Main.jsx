export default function Main() {
  return (
    <div className="d-flex flex-column min-vh-100 bg-primary">
      <h1 className="card-title display-6">Your next stay:</h1>
      <form>
        <div className="mb-3">
          <input
            type="text"
            id="destination"
            placeholder="Where to go?"
          />
        </div>
        <div className="mb-3">
          <input
            type="text"
            id="stay-dates"
            placeholder="Check-in date -- Check-out date"
          />
        </div>
        <div className="mb-3">
          <input
            type="text"
            id="persons"
            placeholder="2 adults, 0 chidren"
          />
        </div>
        <button
          type="submit"
          className="btn button-search"
        >
          Search
        </button>
      </form>
    </div>
  );
}
