document.addEventListener('DOMContentLoaded', function() {
    const links = document.querySelectorAll('.header-right nav ul li a, footer nav ul li a');

    links.forEach(link => {
        link.addEventListener('click', function() {
            links.forEach(link => link.classList.remove('active'));
            this.classList.add('active');
        });
    });
});
