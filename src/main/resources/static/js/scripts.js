document.addEventListener('DOMContentLoaded',()=>{

    const slides = document.querySelectorAll('.slider img');
    let currentIndex = 0 ;
    let interval; 

    function showSlides(index){
        slides.forEach((slides,i)=>{
          slides.style.display = i === index ? 'block': 'none';
            
        });
    }


    function startAutoPlay(){
        interval = setInterval(() =>{
            currentIndex = (currentIndex +1)% slides.length;
            showSlides(currentIndex);
        },2000);
    }

    function stopAutoPlay(){
        clearInterval(interval);
        interval = null
    }


    const slider = document.querySelector('.slider');
    slider.addEventListener('mouseenter',stopAutoPlay);
    slider.addEventListener('mouseleave',startAutoPlay)


    showSlides(currentIndex);
    startAutoPlay();

});

